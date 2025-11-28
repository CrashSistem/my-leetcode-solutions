// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,
//   pub right: Option<Rc<RefCell<TreeNode>>>,
// }
// 
// impl TreeNode {
//   #[inline]
//   pub fn new(val: i32) -> Self {
//     TreeNode {
//       val,
//       left: None,
//       right: None
//     }
//   }
// }
use std::rc::Rc;
use std::cell::RefCell;
impl Solution {
    pub fn is_balanced(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        Self::check_balanced(root).0

}
    fn check_balanced(node: Option<Rc<RefCell<TreeNode>>>) -> (bool, i32) {
        return match node {
            Some(n) => {
                let n_ref = n.borrow();

                let (left_balanced, left_height) = Self::check_balanced(n_ref.left.clone());
                if !left_balanced {
                    return (false, left_height);
                }
                let (right_balanced, right_height) = Self::check_balanced(n_ref.right.clone());
                if !right_balanced {
                    return (false, right_height);
                }

                if (left_height - right_height).abs() > 1 {
                    return (false, left_height);
                }
                let height = 1 + std::cmp::max(left_height, right_height);

                (true, height)
            }
            None => (true, 0)
        }
    }
}
