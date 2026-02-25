pub trait BufLogger {
    fn log(self, p: usize);
}

impl BufLogger for &[u8] {
    fn log(self, p: usize) {
        let mut counter = 0;
        if !self.is_empty() {
            let mut owned_string: String = String::new();
            for item in self.iter().take(p) {
                owned_string.push(char::from(*item));
                print!("{item:#03X} ");
                counter += 1;
                if counter % 16 == 0 {
                    println!("|{owned_string}|");
                    owned_string.clear();
                } else if counter % 8 == 0 {
                    print!("\t");
                }
            }
        }
        println!();
    }
}
