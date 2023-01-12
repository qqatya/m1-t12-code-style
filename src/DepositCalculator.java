import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double result;

        result = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(result, 2);
    }

    double calculateSimplePercent(double amount,double yearRate, int depositPeriod) {
        double result;

        result = amount + amount * yearRate * depositPeriod;
        return round(result, 2);
    }

    double round(double value, int places) {
        double scale;
        double roundResult;

        scale = Math.pow(10, places);
        roundResult = Math.round(value * scale) / scale;
        return roundResult;
    }

    void printDepositResult() {
        int amount;
        int depositPeriod;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double depositResult = 0;

        if (action ==1) {
            depositResult = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (action == 2) {
            depositResult = calculateComplexPercent(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + depositResult);
    }

    public static void main(String[] args) {
        DepositCalculator calculateDeposit = new DepositCalculator();

        calculateDeposit.printDepositResult();
    }




}
