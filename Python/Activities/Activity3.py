# Make a two-player Rock-Paper-Scissors game.

player1 = input("Player 1's name: ")
player2 = input("Player 2's name: ")
player1_selects = input(player1 + "- want to choose rock, paper or scissors? ").lower()
player2_selects = input(player2 + "- want to choose rock, paper or scissors? ").lower()

# Rule 
# Rock beats scissors
# Scissors beats paper
# Paper beats rock
if player1_selects == player2_selects:
    print("It's a tie!")
elif player1_selects == 'rock':
    if player2_selects == 'scissors':
        print("Rock wins!")
    else:
        print("Paper wins!")
elif player1_selects == 'scissors':
    if player2_selects == 'paper':
        print("Scissors win!")
    else:
        print("Rock wins!")
elif player1_selects == 'paper':
    if player2_selects == 'rock':
        print("Paper wins!")
    else:
        print("Scissors win!")
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")