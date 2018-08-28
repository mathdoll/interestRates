package pkg;

public class Task {
    private  int id;
    private  String desc;
    private  String status;
    //TODO: have an ID, description, status

    public Task(TaskBuilder builder) {
        this.id = builder.id;
        this.desc = builder.desc;
        this.status = builder.status;
    }

    public static class TaskBuilder{
        private  int id;
        private  String desc;
        private  String status;

        public TaskBuilder(int id){
            this.id = id;
        }

        public TaskBuilder desc(String desc){
            this.desc = desc;
            return this;
        }

        public TaskBuilder status(String status) {
            this.status = status;
            return this;
        }

        public Task build(){
            return new Task(this);
        }

    }
}
