use dto::{ChunkInfo, FileError, FileHeader};
use std::array::TryFromSliceError;
use std::error::Error;
use std::fs::File;
use std::io::Read;
use std::path::Path;

pub mod hexlog;

const MAGIC_LINE01: &[u8] = "VASC".as_bytes();
const MAGIC_LINE_02: &[u8] = "FZLC".as_bytes();

pub fn check_file(file_path: &Path) -> Result<bool, Box<dyn Error>> {
    let mut file = File::open(file_path).expect("Failed to open file");

    let mut magic = [0; 4];
    file.read_exact(&mut magic)
        .expect("Couldn't read FIRST_FILE_HEADER_MAGIC");

    if magic != MAGIC_LINE01 {
        println!("csav file has wrong magic {magic:02X?}");
        Err(FileError::IncorrectType {
            header_name: "FIRST_MAGIC_HEADER".to_string(),
        })?;
    }
    println!("Correct magic header {magic:02X?}");
    Ok(true)
}
pub fn get_header(data: &[u8]) -> Result<FileHeader, Box<dyn Error>> {
    Ok(FileHeader {
        save_version: parse_u32(data, 4)?,
        game_version: parse_u32(data, 8)?,
        padding: data[12],
        time: parse_u32(data, 13)?,
        date: parse_u32(data, 17)?,
        archive_version: parse_u32(data, 21)?,
    })
}

#[must_use]
pub fn check_second_magic(data: &[u8], start_index: usize) -> bool {
    data.len() >= start_index + 4 && MAGIC_LINE_02 == &data[start_index..start_index + 4]
}

pub fn parse_u32(data: &[u8], start_index: usize) -> Result<u32, TryFromSliceError> {
    let id_bytes: [u8; 4] = data[start_index..start_index + 4].try_into()?;
    let n: u32 = u32::from_le_bytes(id_bytes);

    Ok(n)
}

pub fn get_chunks(data: &[u8], num_chunks: u32) -> Result<Vec<ChunkInfo>, Box<dyn Error>> {
    let mut chunks = Vec::with_capacity(num_chunks as usize);
    for i in 0..num_chunks {
        let offset = 33 + (i * 12) as usize;
        let chunk = ChunkInfo {
            offset: parse_u32(data, offset)?,
            compressed_size: parse_u32(data, offset + 4)?,
            decompressed_size: parse_u32(data, offset + 8)?,
        };
        chunks.push(chunk);
    }
    println!("Chunks: {chunks:?}");
    Ok(chunks)
}
