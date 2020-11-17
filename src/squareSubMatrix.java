public class squareSubMatrix {
        int dimension,firstLine,lastLine,firstColumn,lastColumn;
        int [][] matrix;

        public squareSubMatrix (int i,int lineOne,int lineLast,int columnOne,int [][] matrix){
            dimension=i;
            firstLine=lineOne;lastLine=lineLast;
            firstColumn=columnOne;lastColumn=columnOne+lineLast-lineOne;
            this.matrix=matrix;
        }
        public int getMatrixDimension(){return dimension;}
        public int getSubMatrixDimension(){return lastLine-firstLine+1;}
        public squareSubMatrix clone(){
            int cln=getSubMatrixDimension();
            int[][] clnMatrix=new int[dimension][dimension];
            for (int i=0;i<dimension;i++){
                for(int j=0;j<dimension;j++){
                    clnMatrix[i][j]=matrix[i][j];
                }
            }
            squareSubMatrix resultat= new squareSubMatrix(dimension,firstLine,lastLine-1,firstColumn,clnMatrix);
            return resultat;
        }
        public int get(int row,int column){return matrix[firstLine+row][firstColumn+column];}
        public void set(int row,int column,int value){matrix[firstLine+row][firstColumn+column]=value;}

        public void sum(squareSubMatrix matx){
            int subd = getSubMatrixDimension();
            for(int i=0;i<subd;i++){
                for(int j=0;j<subd;j++){
                    set(i,j,get(i,j)+matx.get(i,j));
                }
            }
        }

        public void product(squareSubMatrix matx){
            int subd=getSubMatrixDimension();
            squareSubMatrix clnMatrix=clone();
            for(int i=0; i<subd; i++) {
                for (int j = 0; j < subd; j++) {
                    for (int k = 0; k < 2; k++) {
                        set(i, j, matx.get(i, j) * clnMatrix.get(i, j));
                    }
                }
            }
        }
}
