impl Solution {
pub fn my_sqrt(x: i32) -> i32 {
    let mut left = 1;
    let mut right = x;
    let mut res = 0;

    while left <= right {
        let mid = (left + right ) / 2;

        if mid <= x / mid{
            res = mid;
            left = mid + 1;
        }
        else {
            right = mid - 1
        }
    }
    return res;
    }
}
