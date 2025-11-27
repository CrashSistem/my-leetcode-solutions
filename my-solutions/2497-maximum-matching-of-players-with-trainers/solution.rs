impl Solution {
  pub fn match_players_and_trainers(players: Vec<i32>, trainers: Vec<i32>) -> i32 {
    let mut sorted_players = players;
    let mut sorted_trainers = trainers;
    sorted_players.sort();
    sorted_trainers.sort();
    let mut i = 0;
    let mut j = 0;
    let mut count = 0;
    while i < sorted_players.len() && j < sorted_trainers.len() {
      if sorted_players[i] <= sorted_trainers[j] {
        count += 1;
        i += 1;
      }
      j += 1;
    }
    return count;
  }
}
