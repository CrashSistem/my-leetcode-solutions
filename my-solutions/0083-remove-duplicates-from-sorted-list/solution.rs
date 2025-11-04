// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//   pub val: i32,
//   pub next: Option<Box<ListNode>>
// }
// 
// impl ListNode {
//   #[inline]
//   fn new(val: i32) -> Self {
//     ListNode {
//       next: None,
//       val
//     }
//   }
// }
impl Solution {
    pub fn delete_duplicates(mut head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    let mut current = &mut head;

    while let Some(node) = current {
        while let Some(next) = &mut node.next {
            if node.val == next.val {
                node.next = next.next.take();
            } else {
                break;
            }
        }
        current = &mut node.next;
    }

    return head;
}
}
