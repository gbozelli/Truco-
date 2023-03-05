public interface card_manager {
    cards[] cards = null;
    public void transfer_cards(card_manager destiny, int quantity, int limit);
    public void delete(cards[] cards, int position);
    public void swap(cards[] cards, int position);
}
