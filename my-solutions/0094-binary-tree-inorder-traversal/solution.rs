// Definition for a binary tree node.

use std::rc::Rc;
use std::cell::RefCell;

impl Solution {
    pub fn inorder_traversal(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let mut result = Vec::new();
        Self::inorder_recursive(root, &mut result);
        result
    }
    
    fn inorder_recursive(node: Option<Rc<RefCell<TreeNode>>>, result: &mut Vec<i32>) {
        if let Some(node_ref) = node {
            let node_borrow = node_ref.borrow();
            
            // Left subtree
            Self::inorder_recursive(node_borrow.left.clone(), result);
            
            // Current node
            result.push(node_borrow.val);
            
            // Right subtree
            Self::inorder_recursive(node_borrow.right.clone(), result);
        }
    }
}
