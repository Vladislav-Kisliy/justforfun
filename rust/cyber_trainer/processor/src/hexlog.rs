use std::fs::File;
use std::io::{BufReader, Read};
use std::path::Path;

pub trait BufLogger {
    fn log(self, p: usize);
}

impl BufLogger for &[u8] {
    fn log(self, p: usize) {
        let mut counter = 0;
        if self.len() > 0 {
            let mut owned_string: String = "".to_owned();
            for i in 0..p {
                owned_string.push(char::from(self[i]));
                print!("{:#03X} ", self[i]);
                counter = counter + 1;
                if counter % 16 == 0 {
                    println!("|{}|", owned_string);
                    owned_string.clear()
                } else if counter % 8 == 0 {
                    print!("\t");
                }
            }
        }
        println!()
    }
}
