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
  pub fn min_depth(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
    Self::min_depth_helper(&root)
  }

  fn min_depth_helper(root: &Option<Rc<RefCell<TreeNode>>>) -> i32 {
    match root {
      Some(node) => {
        let node_ref = node.borrow();
        let left_depth = Self::min_depth_helper(&node_ref.left);
        let right_depth = Self::min_depth_helper(&node_ref.right);

        if left_depth == 0 || right_depth == 0 {
          1 + left_depth + right_depth
        } else {
          1 + std::cmp::min(left_depth, right_depth)
        }
      }
      None => 0,
    }
  }
}
