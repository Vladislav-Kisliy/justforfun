use lz4_flex::decompress_size_prepended;
use processor;
use processor::hexlog::BufLogger;
use std::fs;
use std::path::Path;

fn main() -> Result<(), Box<dyn std::error::Error>> {
    // File header: FileHeader { save_version: 193, game_version: 9, _padding: 0, time: 59845501, date: 2118506496, archive_version: 195 }
    let file_path = Path::new("data/start_1.6.dat");
    // File header: FileHeader { save_version: 263, game_version: 2120, _padding: 0, time: 36888811, date: 2122520576, archive_version: 195 }
    // let file_path = Path::new("data/sav.dat");
    // offset 0:4
    if match processor::check_file(file_path) {
        Ok(value) => value,
        Err(value) => return Err(value),
    } {
        println!("Correct file check #1");
    };
    let vex = fs::read(file_path).expect("Couldn't read the whole file");
    let data = vex.as_slice();

    // Read file header. Offset 5:26
    let header = processor::get_header(data)?;
    println!("File header: {:?}", header);

    // Read chunk directory magic number
    if match processor::check_second_magic(data, 25) {
        Ok(value) => value,
        Err(value) => return Err(value),
    } {
        println!("Correct file check #2");
    };

    // Read number of chunks
    let num_chunks = processor::parse_u32(&data, 29).unwrap();
    println!("Number of chunks: {}", num_chunks);

    let chunks = processor::get_chunks(&data, num_chunks)?;

    // Try to decompress chunks
    println!("Try to decompress chunk #1");
    let chunk0 = chunks.get(0).expect("No any chunks");
    let chunk_slice =
        &data[chunk0.offset as usize..(chunk0.offset + chunk0.compressed_size + 8) as usize];
    println!("Decompressed chunk_slice size: {}", chunk_slice.len());
    chunk_slice.log(32);
    let chunk_slice =
        &data[(chunk0.offset + 4) as usize..(chunk0.offset + chunk0.compressed_size) as usize];
    chunk_slice.log(32);
    let decompressed_chunk0 = decompress_size_prepended(chunk_slice).expect("Couldn't decompress");
    println!("Decompressed chunk0 size: {}", decompressed_chunk0.len());

    decompressed_chunk0.log(64);

    Ok(())
}
