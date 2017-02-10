package net.bluepoet.exercise.deeplearning;

/**
 * Created by daumkakao on 2017. 2. 10..
 */
public class DeepLearningExercise {
    public static void main(String[] args) {
        int[] initRandomWeight = new int[]{-1, 0, 1};
        int[] randomWeight = new int[3];
        int[] a = new int[]{0, 0, 1};
        int randomIndex = 0;
        double sum = 0;
        double output = 0;

        for(int i=0; i< a.length; i++) {
            randomIndex = (int) (Math.random() * 2);
            randomWeight[i] = initRandomWeight[randomIndex];
            System.out.println("randomIndex : "  + randomIndex);
            sum += a[i] * initRandomWeight[randomIndex];

        }
        output = sigmoid(sum);
        System.out.println("output : " + output);

        for(int i=0; i< 3; i++) {
            System.out.println("randomWeight : " + getRandomWeight(0, randomWeight[i], output));
        }

        double[] outputRandomWeights = new double[3];

        for(int i=0; i<10; i++) {
            System.out.println(i + "======================================");
            if(i == 0) {
                outputRandomWeights = getRandomWeightArray(true, null);
            }else{
                outputRandomWeights = getRandomWeightArray(false, outputRandomWeights);
            }
            System.out.println("======================================");
        }
    }

    public static double[] getRandomWeightArray(boolean isFirst, double[] randomWeights) {
        int[] initRandomWeight = new int[]{-1, 0, 1};
        int[] randomWeight = new int[3];
        int[] a = new int[]{0, 0, 1};
        int randomIndex = 0;
        double sum = 0;
        double output = 0;
        double[] outputRandomWeights = new double[3];

        for(int i=0; i< a.length; i++) {
            if(isFirst) {
                randomIndex = (int) (Math.random() * 2);
                randomWeight[i] = initRandomWeight[randomIndex];
//                System.out.println("randomIndex : " + randomIndex);
                sum += a[i] * initRandomWeight[randomIndex];
            }else{
                sum += a[i] * randomWeights[i];
            }
        }

        output = sigmoid(sum);
        System.out.println("output : " + output);

        for(int i=0; i< 3; i++) {
            System.out.println("randomWeight : " + getRandomWeight(0, randomWeight[i], output));
            outputRandomWeights[i] = getRandomWeight(0, randomWeight[i], output);
        }

        return outputRandomWeights;
    }

    public static double getRandomWeight(double answer, double input, double output) {
        double studyRatio = 0.9d;
        double e = answer - output;
        double delta = output * (1 - output) * e;
        return studyRatio * delta * input;
    }

    public static double sigmoid (double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }
}
