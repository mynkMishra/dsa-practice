class Spreadsheet {

    int[][] spreadsheet;
    public Spreadsheet(int rows) {
        spreadsheet = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int[] val = getRowCol(cell);

        int row = val[0];
        int col = val[1];

        spreadsheet[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int[] val = getRowCol(cell);

        int row = val[0];
        int col = val[1];

        spreadsheet[row][col] = 0;
    }
    
    public int getValue(String formula) {
        String X = "";
        int i = 0;

        for(i = 0; i < formula.length(); i++){
            if(formula.charAt(i) != '='){
                if(formula.charAt(i) == '+'){
                    i++;
                    break;
                }

                X += formula.charAt(i) + "";
            }
        }

        String Y = "";
        for(; i < formula.length(); i++){
            Y += formula.charAt(i) + "";
        }

        int val1 = -1;
        int val2 = -1;

        if(isNumber(X)){
            val1 = Integer.parseInt(X);
        }

        if(isNumber(Y)){
            val2 = Integer.parseInt(Y);
        }

        if(val1 != -1 && val2 != -1){
            return val1 + val2;
        }

        if(val1 == -1){
            int[] cell = getRowCol(X);
            val1 = spreadsheet[cell[0]][cell[1]];
        }

        if(val2 == -1){
            int[] cell = getRowCol(Y);
            val2 = spreadsheet[cell[0]][cell[1]];
        }
        
        return val1 + val2;
    }

    private boolean isNumber(String val){

        boolean isNum = false;
        try{
            int num = Integer.parseInt(val);
            isNum = true;
        }catch(Exception e){}

        return isNum;
    }

    private int[] getRowCol(String cell){
        System.out.println(cell);
        int col = cell.charAt(0) - 'A';
        String rowVal = "";

        for(int i = 1; i < cell.length(); i++){
            rowVal += cell.charAt(i) + "";
        }

        int row = Integer.parseInt(rowVal);

        return new int[]{row - 1, col};
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */