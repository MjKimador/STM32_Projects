public class WaveformLUT {
    private static final int N = 128; // Number of points
    private static final int MAX_VALUE = 1023; // Maximum value

    public static void main(String[] args) {
        // Generate LUTs
        int[] sinLUT = generateSinLUT();
        int[] sawtoothLUT = generateSawtoothLUT();
        int[] triangularLUT = generateTriangularLUT();

        // Print LUTs
        System.out.println("Sinusoidal LUT:");
        printLUT(sinLUT);

        System.out.println("\nSawtooth LUT:");
        printLUT(sawtoothLUT);

        System.out.println("\nTriangular LUT:");
        printLUT(triangularLUT);
    }

    // Generate LUT for a sinusoidal wave
    private static int[] generateSinLUT() {
        int[] lut = new int[N];
        for (int i = 0; i < N; i++) {
            double angle = (2 * Math.PI * i) / N;
            lut[i] = (int) Math.round((Math.sin(angle) * (MAX_VALUE / 2)) + (MAX_VALUE / 2));
        }
        return lut;
    }

    // Generate LUT for a sawtooth wave
    private static int[] generateSawtoothLUT() {
        int[] lut = new int[N];
        for (int i = 0; i < N; i++) {
            lut[i] = (MAX_VALUE * i) / N;
        }
        return lut;
    }

    // Generate LUT for a triangular wave
    private static int[] generateTriangularLUT() {
        int[] lut = new int[N];
        for (int i = 0; i < N / 2; i++) {
            lut[i] = (MAX_VALUE * 2 * i) / N;
        }
        for (int i = N / 2; i < N; i++) {
            lut[i] = MAX_VALUE - ((MAX_VALUE * 2 * (i - N / 2)) / N);
        }
        return lut;
    }

    // Print LUT values
    private static void printLUT(int[] lut) {
        for (int value : lut) {
            System.out.print(value + ", ");
        }
        System.out.println();
    }
}
