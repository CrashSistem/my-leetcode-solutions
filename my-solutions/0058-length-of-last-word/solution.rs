impl Solution {
    pub fn length_of_last_word(s: String) -> i32 {
        let mut length = 0;
        let mut found_word = false;

        for ch in s.chars().rev(){
            if ch != ' '{
                found_word = true;
                length +=1
            } else if found_word{
                break;
            }    

        }
        return length
    }
}
