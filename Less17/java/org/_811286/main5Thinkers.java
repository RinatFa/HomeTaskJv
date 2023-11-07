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
public class Main5Thinkers {
        public static int count = 0;
        public static int countFork = 0;

        public static void main(String[] args) {
                Fork fork1 = new Fork(1, false);
                Fork fork2 = new Fork(2, false);
                Fork fork3 = new Fork(3, false);
                Fork fork4 = new Fork(4, false);
                Fork fork5 = new Fork(5, false);
                Thinker think1_Descartes = new Thinker(
                                "Декарт  1", fork1, fork2, 0, false);
                Thinker think2_Leibniz = new Thinker(
                                "Лейбниц 2", fork2, fork3, 0, false);
                Thinker think3_Voltaire = new Thinker(
                                "Вольтер 3", fork3, fork4, 0, false);
                Thinker think4_Rousseau = new Thinker(
                                "Руссо   4", fork4, fork5, 0, false);
                Thinker think5_The_Buddha = new Thinker(
                                "Будда   5", fork5, fork1, 0, false);

                System.out.println();
                Thread thread1_Descartes = new Thread(think1_Descartes);
                Thread thread2_Leibniz = new Thread(think2_Leibniz);
                Thread thread3_Voltaire = new Thread(think3_Voltaire);
                Thread thread4_Rousseau = new Thread(think4_Rousseau);
                Thread thread5_The_Buddha = new Thread(think5_The_Buddha);
                thread5_The_Buddha.start();
                thread1_Descartes.start();
                thread2_Leibniz.start();
                thread3_Voltaire.start();
                thread4_Rousseau.start();
        }
}
