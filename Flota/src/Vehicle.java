public abstract class Vehicle {

    private final String id;
    private final VehicleType vehicleType;
    private final String brand;
    private double weight;
    private double course;
    private GpsTracker actualLocation;

    public enum VehicleType {
        Truck,
        Car,
        Bus,
    }

    public Vehicle(String id, VehicleType vehicleType, String brand, double weight, double course) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.weight = weight;
        this.course = course;
        this.actualLocation = new GpsTracker(0, 0);
    }

    public GpsTracker getActualLocation() {
        return actualLocation;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public double getWeight() {
        return weight;
    }

    public double getCourse() {
        return course;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    public void setActualLocation(double latitude, double longitude) {
        this.actualLocation = new GpsTracker(latitude, longitude);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode() + 1;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Vehicle) {
            return this.id.equals(((Vehicle) object).getId());
        }
        return false;
    }



    public class GpsTracker {
        private double latitude;
        private double longitude;

        GpsTracker(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            if (latitude == 0 && longitude == 0) {
                return "IN BASE.";
            } else {
                return "LA = " + Double.toString(latitude) + " $ LO = " + Double.toString(longitude);
            }
        }
    }
}
