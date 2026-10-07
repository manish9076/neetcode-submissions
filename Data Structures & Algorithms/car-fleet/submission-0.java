class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length, res = 1;
        if(n == 0){
            return 0;
        }

        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++){
            double time = (double)(target - position[i]) / speed[i];

            cars[i] = new Car(position[i], time);
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b.pos, a.pos));

        int fleets = 1;
        double prevTime = cars[0].time;

        for(int i = 1; i < n; i++){
            if(cars[i].time > prevTime){
                fleets++;
                prevTime = cars[i].time;     
            }
        }
        return fleets;
    }

    class Car {
        int pos;
        double time;

        Car(int pos, double time){
            this.pos = pos;
            this.time = time;
        }
    }

}
