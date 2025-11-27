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
  pub fn has_path_sum(root: Option<Rc<RefCell<TreeNode>>>, target_sum: i32) -> bool {
    match root {
      Some(node) => {
        let node_ref = node.borrow();

        if node_ref.left == None && node_ref.right == None {
          return node_ref.val == target_sum;
        }
        let remaining = target_sum - node_ref.val;
        Self::has_path_sum(node_ref.left.clone(), remaining )
        || Self::has_path_sum(node_ref.right.clone(), remaining )
        
      }
      None => false,

    }

  }
}

