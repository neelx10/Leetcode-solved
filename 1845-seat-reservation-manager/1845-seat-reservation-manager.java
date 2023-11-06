class SeatManager {
    int marker;
    PriorityQueue<Integer> availableSeats;

    public SeatManager(int n) {
        marker = 1;
        availableSeats = new PriorityQueue<>();
    }

    public int reserve() {
        return !availableSeats.isEmpty()?availableSeats.poll():marker++;
    }

    public void unreserve(int seatNumber) {
        availableSeats.offer(seatNumber);
    }
}
/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */