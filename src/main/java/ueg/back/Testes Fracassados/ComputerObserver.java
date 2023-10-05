/*package ueg.back;
/*package ueg.back;

public class ComputerObserver implements Observer{
    public class ComputerObserver implements Observer {
        private String computerName;
        private OperationSubject operationSubject;

        public ComputerObserver(String computerName, OperationSubject operationSubject) {
            this.computerName = computerName;
            this.operationSubject = operationSubject;
            this.operationSubject.addObserver(this);
        }

        @Override
        public void update() {
            Command command = operationSubject.getCurrentCommand();
            // Lógica para lidar com a notificação (atribuição de uma operação)
            System.out.println(computerName + " executando a operação: " + command.getClass().getSimpleName());
        }
    }

}

*/
