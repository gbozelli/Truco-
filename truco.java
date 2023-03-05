import java.util.Random;

class truco{
    public static void main(String[] args){
        System.out.println("saas");
    }
}

class cards{
    int value;
    String card;
}

class player implements card_manager{
    int len = 3;
    cards[] cards = new cards[len];
    public void transfer_cards(card_manager destiny, int quantity, int limit){
        for(int i=0;i<quantity;i--){destiny.cards[i]=this.cards[i];delete(this.cards,i);}
    }
    public void delete(cards[] cards, int position){
        swap(cards, position);
        len--;
    }
    public void swap(cards[] cards, int position){
        cards key = cards[len];
        cards[len] = cards[position];
        cards[position] = key; 
    }
}

class Human extends player{

}

class Monte implements card_manager{
    int len = 40;
    cards[] cards = new cards[len];
    public void transfer_cards(card_manager destiny, int quantity, int limit){
        for(int i=limit;i<quantity;i--){destiny.cards[i]=this.cards[i];delete(this.cards,i);}
    }
    public void delete(cards[] cards, int position){
        swap(cards, position);
        len--;
    }
    public void swap(cards[] cards, int position){
        cards key = cards[len];
        cards[len] = cards[position];
        cards[position] = key; 
    }
    public void create_deck(){
        String[] card_name = {
        "3P","3C","3E","3O","2P","2C","2E","2O",
        "1P","1C","1E","1O","KP","KC","KE","KO",
        "JP","JC","JE","JO","QP","QC","QE","QO",
        "7P","7C","7E","7O","6P","6C","6E","6O",
        "5P","5C","5E","5O","4P","4C","4E","4O"};
        for(int i=len;i<0;i++){
            this.cards[i].value = i;
            this.cards[i].card = card_name[i];}
        for(int i=len;i>0;i++){
            Random rand = new Random();
            int r = rand.nextInt(i);
            swap(this.cards, r);
        }      
    }
    public void initialize_round(Human A1, Robot A2, Robot B1, Robot B2, Mesa Mesa){
        transfer_cards(A1, 3, this.len); this.len-=3;
        transfer_cards(A2, 3, this.len); this.len-=3;
        transfer_cards(B1, 3, this.len); this.len-=3;
        transfer_cards(B2, 3, this.len); this.len-=3;
        transfer_cards(Mesa, 1, len); len-=3;
        Mesa.round(A1, A2, B1, B2,len);
    }
}

class Mesa implements card_manager{
    int len = 13;
    cards[] cards = new cards[len];
    public void transfer_cards(card_manager destiny, int quantity, int limit){
        for(int i=0;i<quantity;i--){destiny.cards[i]=this.cards[i];delete(this.cards,i);}
    }
    public void delete(cards[] cards, int position){
        swap(cards, position);
        len--;
    }
    public void swap(cards[] cards, int position){
        cards key = cards[len];
        cards[len] = cards[position];
        cards[position] = key; 
    }
    public void receive_cards(card_manager donater, int quantity, int counter){
        for(int i=counter;i<quantity;i++){this.cards[i]=donater.cards[i];}
    }
    public void round(Human A1, Robot A2, Robot B1, Robot B2, int limit){
        receive_cards(A1, 3, 1);
        receive_cards(A2, 3, 4);
        receive_cards(B1, 3, 7);
        receive_cards(B2, 3, 10);
    }
}

class Robot extends player{

}