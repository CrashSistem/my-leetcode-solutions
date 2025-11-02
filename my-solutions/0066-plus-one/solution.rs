impl Solution {
    pub fn plus_one(mut digits: Vec<i32>) -> Vec<i32> {
    let  length = digits.len();

    for i in (0..length).rev() {
        if digits[i] < 9{
            digits[i] += 1;
            return digits;
        }
        digits[i] = 0;
    }
    digits.insert(0, 1);
    return digits;
}
}
