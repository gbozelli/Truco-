
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
    int len;
    int limit = len;
    public void transfer_cards(card_manager destiny, int quantity){
        for(int i=0;i<quantity;i++){destiny.cards[i]=this.cards[i];delete(this.cards,i);this.limit--;}
    }
    public void delete(cards[] cards, int position){
        swap(cards, position);
    }
    public void swap(cards[] cards, int position){
        cards key = cards[len];
        cards[len] = cards[position];
        cards[position] = key; 
    }
    public void sort(){
        int current_number;
        for(int i =1; i<this.limit; i++){
            current_number = this.cards[i].value;
            int j = i-1;
            while(this.cards[j].value>current_number & j>=0){
                this.cards[j+1].value = this.cards[j].value;
                j = j-1;
        }
            this.cards[j+1].value = current_number;}}
    public void ordenate(){
        cards main_card = this.cards[13];
        int sequency = (main_card.value/4)*4;
        for(sequency=sequency;sequency<sequency+4;sequency++){
            this.cards[sequency].value += 40;
        }
        sort();
    }
}

class Human extends player{
    int len = 3;
    cards[] cards = new cards[len];
}

class Monte extends player{
    int len = 40;
    cards[] cards = new cards[len];
    int limit = len;
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
        cards main_card = this.cards[13];
        for(int i=((main_card.value/4)*4)+4;i<((main_card.value/4)*4)+8;i++){
            this.cards[i].value += 40;}
        transfer_cards(A1, 3);
        transfer_cards(A2, 3);
        transfer_cards(B1, 3);
        transfer_cards(B2, 3);
    }
}

class Mesa extends player{
    int len = 13;
    cards[] cards = new cards[len];
    int limit = len;
    public void receive_cards(card_manager donater, int quantity, int counter){
        for(int i=counter;i<quantity;i++){this.cards[i]=donater.cards[i];}
    }
}

class Robot extends player{
    public void play(){
        sort();
        
    }
}