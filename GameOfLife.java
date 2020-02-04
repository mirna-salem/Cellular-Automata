import java.util.Random;
public class GameOfLife
{
   private int [][] grid;
   private int [][] temp;
   
   public GameOfLife(int x, int y)
   {
      int [][] temp = new int[x][y];
      int [][] grid = new int[x][y];
      
      this.grid = grid;
      this.temp = temp;
   }
   
   public int [][] getGrid()
   {
      return this.grid;
   }
   
   public void nextIteration()
   {
      for ( int row = 1 ; row < this.grid.length-1; row++)
      {
         for ( int col = 1 ; col < this.grid[row].length-1; col++)
         {
            int liveCount = 0;
            int deadCount = 0;
            
            if ( this.grid[row][col] == 1 ) //checks the live cells
            {
               if(this.grid[row][col-1] == 1 ) 
                  liveCount++;
               if ((this.grid[row][col+1] == 1))
                  liveCount++;
               if ((this.grid[row-1][col] == 1)) 
                  liveCount++;
               if ((this.grid[row+1][col] == 1))
                  liveCount++;
               if ((this.grid[row-1][col-1] == 1))
                  liveCount++;
               if ((this.grid[row+1][col+1] == 1))
                  liveCount++;
               if ((this.grid[row-1][col+1] == 1))
                  liveCount++;
               if((this.grid[row+1][col-1] == 1))
                  liveCount++;
               
            }
            
            else if ( this.grid[row][col] == 0 ) //checks the dead cells
            {
               if(this.grid[row][col-1] == 1 ) 
                  deadCount++;
               if ((this.grid[row][col+1] == 1))
                  deadCount++;
               if ((this.grid[row-1][col] == 1)) 
                  deadCount++;
               if ((this.grid[row+1][col] == 1))
                  deadCount++;
               if ((this.grid[row-1][col-1] == 1))
                  deadCount++;
               if ((this.grid[row+1][col+1] == 1))
                  deadCount++;
               if ((this.grid[row-1][col+1] == 1))
                  deadCount++;
               if((this.grid[row+1][col-1] == 1))
                  deadCount++;
               
             }
              
              if ( this.grid[row][col] == 1 && (liveCount < 2 || liveCount > 3 ))
                  this.temp[row][col] = 0;
              else if (this.grid[row][col] == 1 && (liveCount == 2 || liveCount == 3))
                  this.temp[row][col] = 1;
              else if ( this.grid[row][col] == 0 && deadCount == 3 )
                  this.temp[row][col] = 1;
              else
                  this.temp[row][col] = 0;
                                    
         }
      }
      
      for ( int row = 0 ; row < this.grid.length; row++)
      {
         for ( int col = 0 ; col < this.grid[row].length; col++)
         {
            this.grid[row][col] = this.temp[row][col];
         }
      }
        
   }
   
   public void oscillatePatternInitialGrid()
   {
      int middleRow = (this.grid.length / 2 ) - 1;
      int middleCol = (this.grid[0].length / 2) - 1;
      
      for ( int row = 0 ; row < this.grid.length ; row++)
      {
         for ( int col = 0 ; col < this.grid[row].length; col++)
         {
            this.grid[row][col] = 0;                 
         }
      }

      
      for ( int row = 0 ; row < this.grid.length ; row++)
      {
         for ( int col = 0 ; col < this.grid[row].length; col++)
         {
            if ( row == middleRow && col == middleCol)
            {
               this.grid[row][col] = 1;
               this.grid[row][col-1] = 1;
               this.grid[row][col+1] = 1;
            }
               
         }
      }
            
   }
   
   public void blockPatternInitialGrid()
   {
      int middleRow = (this.grid.length / 2 ) - 1;
      int middleCol = (this.grid[0].length / 2) - 1;
      
      for ( int row = 0 ; row < this.grid.length ; row++)
      {
         for ( int col = 0 ; col < this.grid[row].length; col++)
         {
            this.grid[row][col] = 0;                 
         }
      }

      
      for ( int row = 0 ; row < this.grid.length ; row++)
      {
         for ( int col = 0 ; col < this.grid[row].length; col++)
         {
            if ( row == middleRow && col == middleCol)
            {
               this.grid[row][col] = 1;
               this.grid[row+1][col] = 1;
               this.grid[row][col+1] = 1;
               this.grid[row+1][col+1] = 1;
            }
               
         }
      }

   }
   
   public void randomizeInitialGrid()
   {
      Random r = new Random();
      for ( int row = 0 ; row < this.grid.length ; row++)
      {
         for ( int col = 0 ; col < this.grid[row].length; col++)
         {
            this.grid[row][col] = r.nextInt(2);                
         }
      }
 
   }
   
}