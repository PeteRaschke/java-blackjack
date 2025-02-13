# Console Blackjack Using Java

## Project Description
This project is a playable console version of blackjack. You can choose your starting balance and play until it reaches zero, you can also choose whether or not to have a new shoe reshuffled after each hand. The rules are similar to most versions of blackjack but:
- No splitting or insurance (May be implemented in the future)
- All wins pay out two to one
- Each shoe is one deck
- The deck is automatically reshuffled after 4 hands

## How to Install and Run
This is just the code. You will need to download the files and run it using an IDE.

## How to Use
Once the program is running you will be prompted to enter your balance, this needs to be a positive integer:

![Balance](https://github.com/user-attachments/assets/88885b1c-2b12-4b0b-91f1-6ae643c5a779)

Then you will be asked if you want a new Shoe, saying no at this point will close the program:

![New Shoe](https://github.com/user-attachments/assets/ee93b864-5cbc-4bb6-90b0-2014d7e541b4)

After answering yes you will be prompted to enter a bet before the cards are dealt, the bet can be any positive integer up to your balance (No minimum bet size):

![Place bet](https://github.com/user-attachments/assets/c0a33b09-60aa-4a5f-91c1-76b170d4bd7c)

After choosing your bet, both you and the dealer will be dealt two cards with one of the dealer's cards being hidden from you. At this point, you can choose to hit, stay, double down, or quit the game:

![Play](https://github.com/user-attachments/assets/31f0983d-fa31-4d08-b1c2-54067df5b20c)

After the player's turn, the dealer will take its turn, the hidden card is revealed and the hands are scored, you then can choose whether or not to continue with the same shoe:

![Score](https://github.com/user-attachments/assets/d35f34fe-3067-4dcd-b361-fccf4efed5df)

Play will continue until the player quits or the balance reaches zero.
