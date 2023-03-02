public class card_manager {
    int len;
    cards[] cards = new cards[len];
    void transfer_cards(card_manager destiny, int quantity){
        for(int i=0;i<quantity;i++){destiny.cards[i]=this.cards[i];delete(this.cards,i);}
    }
    void delete(cards[] cards, int position){
        swap(cards, position);
        len--;
    }
    void swap(cards[] cards, int position){
        cards key = cards[len];
        cards[len] = cards[position];
        cards[position] = key; 
    }
}
