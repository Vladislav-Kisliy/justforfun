#[derive(Debug)]
pub struct FileHeader {
    pub save_version: u32,
    pub game_version: u32,
    pub padding: u8,
    pub time: u32,
    pub date: u32,
    pub archive_version: u32,
}

#[derive(Debug)]
pub struct ChunkInfo {
    pub offset: u32,
    pub compressed_size: u32,
    pub decompressed_size: u32,
}

#[derive(Debug, thiserror::Error)]
pub enum FileError {
    #[error("File not found: {name}")]
    NotFound { name: String },
    #[error("Incorrect magic header {header_name}")]
    IncorrectType { header_name: String },
}
