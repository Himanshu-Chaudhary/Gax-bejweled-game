package com.putable.gax.gaxby;

import java.util.Random;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Gactor;
import com.putable.gax.core.Level;
import com.putable.gax.core.Outcome;

public class GactorEngine implements Engine{
	private Random random = new Random();
	private int randomCount = 1 , score = 0;
	private Level level;
	private boolean isLevelSet = false;
	int row,column,step = row*column;
	int temprow,tempcolumn;
	private Gactor[][] gactor = new Gactor[row][column];
	
	
	@Override
	public Random getRandom() {
		
		
		return random;
	}

	@Override
	public long scorePoints(long increment) {
		score+=increment;
		return score;
	}

	@Override
	public void setLevel(Level level) {
		if (level==null) throw new NullPointerException();
		this.level = level;
		column = level.getGridWidth();
		row = level.getGridHeight();
		gactor= new Gactor[row][column];
		isLevelSet = true;
		
	}

	@Override
	public Level getLevel() {
		if (isLevelSet) return this.level;
		return null;
	}

	@Override
	public void restartLevel() {
		if (!isLevelSet) throw new IllegalStateException();
		level.gridInitialize(this);
	}

	@Override
	public Outcome step() {
		step++;
		
		temprow= getRandom().nextInt(row);
		tempcolumn = getRandom().nextInt(column);
		
		if (gactor[temprow][tempcolumn] == null) return null;
		return gactor[temprow][tempcolumn].act(this, tempcolumn, temprow);		
	}

	@Override
	public boolean exists(int x, int y) {
		boolean isPositive = (x >= 0 && y >= 0);
		if ((x < column && y < row)&& isPositive)  return true;
		return false;
	}

	@Override
	public Gactor get(int x, int y) {
		if (!(exists(x,y))) throw new IllegalArgumentException ();
		if (gactor[y][x] ==null) return null;
		return gactor [y][x];
	}

	@Override
	public Gactor clear(int x, int y) {
		Gactor temp;
		if (!(exists(x,y))) throw new IllegalArgumentException ();
		if (gactor[y][x] ==null) return null; 
		temp = gactor[y][x];
		gactor[y][x] = null;
		return temp;
	}

	@Override
	public void set(int x, int y, Gactor a) {
		if (!(exists(x,y))) throw new IllegalArgumentException ();
		if (a ==null) throw new IllegalArgumentException ();
		if (gactor[y][x] !=null) throw new IllegalStateException();
		gactor[y][x]=  a;
		
	}

	@Override
	public int getWidth() {
		return row;
	}

	@Override
	public int getHeight() {
		return column;
	}

	@Override
	public int getBurstNumber() {
		return step;
	}

}
