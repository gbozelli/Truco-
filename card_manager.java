public interface card_manager {
    cards[] cards = null;
    public void transfer_cards(player destiny, int quantity);
    public void delete(cards[] cards, int position);
    public void swap(cards[] cards, int position);
    public void sort();
    public void clean_deck();
    public void special_card(player p, cards[] card,int i);
}
