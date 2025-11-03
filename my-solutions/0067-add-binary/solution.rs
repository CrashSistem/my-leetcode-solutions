impl Solution{
pub fn add_binary(a: String, b: String) -> String {
    let mut result = String::new();
    let mut carry = 0;
    let mut i = a.len();
    let mut j = b.len();

    // Loop while there are digits in either string or a carry remains
    while i > 0 || j > 0 || carry > 0 {
        // Get the bit from string a, or 0 if we've reached the start of a
        let bit_a = if i > 0 {
            a.chars().nth(i - 1).unwrap().to_digit(2).unwrap()
        } else {
            0
        };
        // Get the bit from string b, or 0 if we've reached the start of b
        let bit_b = if j > 0 {
            b.chars().nth(j - 1).unwrap().to_digit(2).unwrap()
        } else {
            0
        };

        // Calculate the sum for the current position
        let current_sum = bit_a + bit_b + carry;

        // The result bit is the sum modulo 2
        let result_bit = current_sum % 2;
        result.insert(0, char::from_digit(result_bit, 2).unwrap());

        // The new carry is the sum integer-divided by 2
        carry = current_sum / 2;

        // Move to the next position (to the left)
        if i > 0 { i -= 1; }
        if j > 0 { j -= 1; }
    }

    return result
    }
}
