use std::collections::HashSet;
impl Solution {
  pub fn repeated_character(s: String) -> char {
    let mut set: HashSet<char> = HashSet::new();

    for i in s.chars() {
      if set.contains(&i) {
        return i;
      }
      set.insert(i);
    }
    panic!("No repeated character found");
  }
}
