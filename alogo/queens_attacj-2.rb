#!/bin/ruby

## Queen's Attack II
## https://www.hackerrank.com/challenges/queens-attack-2

n,k = gets.strip.split(' ')
n = n.to_i
k = k.to_i
rQueen,cQueen = gets.strip.split(' ')
rQueen = rQueen.to_i
cQueen = cQueen.to_i
blocks = {}
moves = 0
for a0 in (0..k-1)
    rObstacle,cObstacle = gets.strip.split(' ')
    # rObstacle = rObstacle.to_i
    # cObstacle = cObstacle.to_i
    # your code goes here
    blocks[rObstacle + ' ' + cObstacle] = true;
end

# Count moves of the queen.
def count_moves(currentRow, currentCol, incrementRow, incrementCol, n, blocks, moves)
    row, col = currentRow, currentCol
    row = row + incrementRow
    col = col + incrementCol
    while( row >= 1 && row <= n && col >= 1 && col <= n ) do
        # puts "#{row}, #{col}"
        break if blocks[row.to_s + ' ' + col.to_s]
        row = row + incrementRow
        col = col + incrementCol
        moves = moves + 1
    end
    moves
end

[[-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1]].each do |c|
  moves = count_moves(rQueen, cQueen, c[0], c[1], n, blocks, moves)
end

puts moves
