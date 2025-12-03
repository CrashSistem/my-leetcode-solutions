use std::collections::HashMap;
impl Solution {
  pub fn is_isomorphic(s: String, t: String) -> bool {
    if s.len() != t.len() {
      return false;
    }

    let s_chars: Vec<char> = s.chars().collect();
    let t_chars: Vec<char> = t.chars().collect();

    let mut s_to_t = HashMap::new();
    let mut t_to_s = HashMap::new();

    for i in 0..s_chars.len() {
      let s_char = s_chars[i];
      let t_char = t_chars[i];

      // Проверяем отображение s → t
      match s_to_t.get(&s_char) {
        Some(&mapped) => {
          if mapped != t_char {
            return false;
          }
        }
        None => {
          if t_to_s.contains_key(&t_char) {
            return false;
          }
          s_to_t.insert(s_char, t_char);
        }
      }
      match t_to_s.get(&t_char) {
        Some(&mapped) => {
          if mapped != s_char {
            return false;
          }
        }
        None => {
          t_to_s.insert(t_char, s_char);
        }
      }
    }
    true
  }
}
