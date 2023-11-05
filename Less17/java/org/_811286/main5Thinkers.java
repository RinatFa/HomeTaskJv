package org._811286;

/**
 * main5Thinkers
 * 1. Пять безмолвных философов сидят вокруг круглого стола,
 * перед каждым философом стоит тарелка спагетти.
 * 2. Вилки лежат на столе между каждой парой ближайших философов.
 * 3. Каждый философ может либо есть, либо размышлять.
 * 4. Философ может есть только тогда, когда держит две вилки -
 * взятую справа и слева.
 * 5. Философ не может есть два раза подряд, не прервавшись
 * на размышления (можно не учитывать)
 * 6. Философ может взять только две вилки сразу, то есть обе вилки
 * должны быть свободны
 * Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
 */
public class main5Thinkers {
    public static int count = 0;

    public static void main(String[] args) {
        fork fork1 = new fork(1, false);
        fork fork2 = new fork(2, false);
        fork fork3 = new fork(3, false);
        fork fork4 = new fork(4, false);
        fork fork5 = new fork(5, false);
        thinker think1_Descartes = new thinker(
                "Декарт  1", fork1, fork2, 0, false);
        thinker think2_Leibniz = new thinker(
                "Лейбниц 2", fork2, fork3, 0, false);
        thinker think3_Voltaire = new thinker(
                "Вольтер 3", fork3, fork4, 0, false);
        thinker think4_Rousseau = new thinker(
                "Руссо   4", fork4, fork5, 0, false);
        thinker think5_The_Buddha = new thinker(
                "Будда   5", fork5, fork1, 0, false);

        System.out.println();
        Thread thread1_Descartes = new Thread(think1_Descartes);
        Thread thread2_Leibniz = new Thread(think2_Leibniz);
        Thread thread3_Voltaire = new Thread(think3_Voltaire);
        Thread thread4_Rousseau = new Thread(think4_Rousseau);
        Thread thread5_The_Buddha = new Thread(think5_The_Buddha);
        thread1_Descartes.start();
        thread2_Leibniz.start();
        thread3_Voltaire.start();
        thread4_Rousseau.start();
        thread5_The_Buddha.start();
    }
}
