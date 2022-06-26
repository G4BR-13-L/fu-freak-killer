public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    // ===========================================
    void checkOut(IntegracaoFormaPagemento formaPagamento,Recibo recibo) {
        Moeda total = Moeda.zero;
        for (item : items) {
          total += item.getPreco();
          recibo.addItem(item);
        }
        Pagamento p = formaPagamento.pagar(total);
        recibo.addPagamento(p);
      }
    // ===========================================

    private Pagamento aceitaDinheiro(Moeda total) {
        return null;
    }
}
