public abstract class Calculate {

    boolean requireOneInput;

    public Calculate() {
        if (calc(-96874))
            requireOneInput = true;
        else
            requireOneInput = false;
    }

    public abstract void calc(int num1, int num2);
    public abstract boolean calc(int num1);
}

class Sum extends Calculate {
    @Override
    public void calc(int num1, int num2) {
        System.out.println("Sonuç: " + (num1+num2));
    }

    @Override
    public boolean calc(int num1) { return false; }
}

class Negate extends Calculate {
    @Override
    public void calc(int num1, int num2) {
        System.out.println("Sonuç: " + (num1-num2));
    }
    @Override
    public boolean calc(int num1) { return false; }
}

class Divide extends Calculate {
    @Override
    public void calc(int num1, int num2) {
        System.out.println("Sonuç: " + (num1/num2));
    }
    @Override
    public boolean calc(int num1) { return false; }
}

class Multiple extends Calculate {
    @Override
    public void calc(int num1, int num2) {
        System.out.println("Sonuç: " + (num1*num2));
    }
    @Override
    public boolean calc(int num1) { return false; }
}

class Root extends Calculate {
    @Override
    public void calc(int num1, int num2) {
        System.out.println("Sonuç: " + (Math.pow(num1, num2)));
    }
    @Override
    public boolean calc(int num1) { return false; }
}

class Expo extends Calculate {
    @Override
    public void calc(int num1, int num2) {
        int result = 1;
        for (int i = 1 ; i <= num2; i++)
            result *= num1;
        System.out.println("Sonuç: " + result);
    }
    @Override
    public boolean calc(int num1) { return false; }
}

class Mod extends Calculate {
    @Override
    public void calc(int num1, int num2) {
        System.out.println("Sonuç: " + (num1%num2));
    }
    @Override
    public boolean calc(int num1) { return false; }
}

class Factorial extends Calculate {
    @Override
    public void calc(int num1, int num2) {}
    @Override
    public boolean calc(int num1) {
        if (num1 == -96874) {
            return true;}
        int result = 1;
        for (int i = 1; i <= num1; i++) {
            result *= i;
        }
        System.out.println("Sonuç: " + (result));
        return true;
    }
}

class Absolute extends Calculate {

    @Override
    public void calc(int num1, int num2) {}

    @Override
    public boolean calc(int num1) {
        if (num1 == -96874) {
            return true;}
        System.out.println("Sonuç: " + Math.abs(num1));
        return true;
    }
}
