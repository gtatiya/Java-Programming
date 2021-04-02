package b_coding_interview.Problems;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
Polygon Distances

A two-dimensional polygon with (N+1) sides is described by a clockwise list of points [(x0, Y0), (x1, y1) (xN, yN)].
In this problem, assume all polygons are convex, meaning all interior angles are less than 180 degrees.
Write a program that computes the shortest straight-line distance from the polygon to a query point (xq, yq) which is outside of the polygon. 

Input format 
The first parameter is a list of the x values of the polygon vertices: (xo, x1, … xN)
The second parameter is a list of the y values of the polygon vertices: (y1, y2, … yN)
The third parameter is the x value of the query point: xq 
The fourth parameter is the y value of the query point: yq 

Constraints
2 <= N <= 20 (i.e. the polygon has at least 3 sides) 

Output format 
The shortest distance between the polygon and the query point. 

Note: don't worry about the rounding in the examples below, just return an accurate distance estimate.
Your answer will be automatically rounded to 3 decimal places to match an expected output. 
*/

public class PolygonDistance {

	public static void main(String[] args) {
		
//		List<Double> polygonX = Arrays.asList(0.0, 1.0, 3.0);
//		List<Double> polygonY = Arrays.asList(5.0, 1.0, 0.0);
//		double queryX = 3.0, queryY = 2.0;
		
//		List<Double> polygonX = Arrays.asList(0.0, -1.0, 0.0);
//		List<Double> polygonY = Arrays.asList(0.0, 0.0, -1.0);
//		double queryX = 1.0, queryY = 0.0;
		
//		List<Double> polygonX = Arrays.asList(0.0, 2.0, 14.0, 6.0);
//		List<Double> polygonY = Arrays.asList(0.0, 8.0, 10.0, 1.0);
//		double queryX = 12.0, queryY = 4.0;
		
		List<Double> polygonX = Arrays.asList(9.0, 5.0, 3.0, 6.0, 8.0);
		List<Double> polygonY = Arrays.asList(5.0, 4.0, 2.0, 2.0, 3.0);
		double queryX = 9.0, queryY = 3.0;
		
		Polygon polygon = new Polygon();
		for (int i = 0; i < polygonX.size(); i++) {
			polygon.addPoint(polygonX.get(i).intValue(), polygonY.get(i).intValue());
		}
		
		double min_dis = Double.POSITIVE_INFINITY;
		double x_min = 0, y_min = 0;
		for (int i = 0; i < polygonX.size(); i++) {
			Double x1 = polygonX.get(i);
			Double y1 = polygonY.get(i);
			
			double dist = findDist2pts(x1, y1, queryX, queryY);
			if (dist < min_dis) {
		        min_dis = dist;
		        x_min = x1;
		        y_min = y1;
			}		
		}
		System.out.println("min_dis: " + min_dis);
		System.out.println("x_min, y_min: " + x_min + " " + y_min);
		
		double beam_range_factor = 1.5;
		int num_beams = 10;
		double x_min_new = Double.POSITIVE_INFINITY, y_min_new = Double.POSITIVE_INFINITY;
		while ((x_min != x_min_new) && (y_min != y_min_new)) {
		    if (x_min_new != Double.POSITIVE_INFINITY) {
		        x_min = x_min_new;
		    }
		    if (y_min_new != Double.POSITIVE_INFINITY) {
		        y_min = y_min_new;		    	
		    }
		    System.out.println("x_min, y_min: " + x_min + " " + y_min);
		    		        
		    Double radian = Math.atan2(y_min-queryY, x_min-queryX);
		    System.out.println("radian: " + radian);
		    
		    beam_range_factor = beam_range_factor + 0.5;
		    List<Double> angles_list = linspace(radian - (Math.PI / beam_range_factor),
		    									radian + (Math.PI / beam_range_factor), num_beams + 1);
		    System.out.print("angles_list: ");
		    for (Double angle : angles_list) {
		        System.out.print(angle + " ");
		    }
		    System.out.println("");
		    
		    int[] beam_len_list = IntStream.range(1, (int) min_dis + 1).toArray();
		    for (int i = beam_len_list.length - 1; i >= 0; i--) {
		    	System.out.println("beam_len: " + beam_len_list[i]);
		    	Double beam_len = beam_len_list[i] + 0.01;
		    	for (Double angle : angles_list) {
		    		System.out.println("angle: " + angle);
		    		Double x_ratio = Math.cos(angle), y_ratio = Math.sin(angle);
		    		
		    		Double x = queryX + beam_len * x_ratio;
		    		Double y = queryY + beam_len * y_ratio;
		    		
		    		System.out.println("x, y: " + x + " " + y);
		    		System.out.println("contains: " + polygon.contains(x, y));
		    		
		    		if (polygon.contains(x, y)){
		    			List<Double> x_y = find_pt_on_polygon(beam_len, x_min, y_min, queryX, queryY,
		    													x_ratio, y_ratio, polygon);
		    			x = x_y.get(0);
		    			y = x_y.get(1);
		    			double dist = findDist2pts(x, y, queryX, queryY);
		    			System.out.println("dist: " + dist);
		    			
		    			if (dist < min_dis) {
		    		        min_dis = dist;
		    		        x_min_new = x;
		    		        y_min_new = y;
		    		        System.out.println("x_min_new, y_min_new: " + x_min_new + " " + y_min_new);
		    			}
		    		}
		    	}
		    }
		    if (x_min_new == Double.POSITIVE_INFINITY) {
		    	x_min_new = x_min;
		    }
		    if (y_min_new == Double.POSITIVE_INFINITY) {
		    	y_min_new = y_min;
		    }
		}
		
		System.out.println("FINAL x_min_new, y_min_new: " + x_min_new + " " + y_min_new);
		double dist = findDist2pts(x_min_new, y_min_new, queryX, queryY);
		System.out.println("FINAL dist: " + dist);
	}
	
	public static double findDist2pts(double x1, double y1, double x2, double y2) {
		
		double distance = Math.hypot(x1-x2, y1-y2);
		
		return distance;
	}
	
	public static List<Double> find_pt_on_polygon(Double beam_len, double x_min, double y_min,
								double queryX, double queryY, Double x_ratio, Double y_ratio, Polygon polygon) {
		
		List<Double> results = new ArrayList<Double>();
		double min_dis = Double.POSITIVE_INFINITY;
		for (Double beam_len2 = beam_len; beam_len2 >= 0.01; beam_len2 = beam_len2 - 0.01) {
//			System.out.println("beam_len2: " + beam_len2);
			Double x = queryX + beam_len2 * x_ratio;
    		Double y = queryY + beam_len2 * y_ratio;
    		if (polygon.contains(x, y)){
    			double dist = findDist2pts(x, y, queryX, queryY);
    			if (dist < min_dis) {
    		        min_dis = dist;
    		        x_min = x;
    		        y_min = y;
    			}
    		}
		}
		results.add(x_min);
		results.add(y_min);
		
		return results;
	}
	
	public static List<Double> linspace(double min, double max, int n){
		
	   List<Double> results = new ArrayList<Double>();
	   
//	   double min = Math.min(first, last);
//	   double max = Math.max(first, last);

	   double step = (max - min) / (n - 1);
	   for(int i = 0; i <= n-2; i++){
	       results.add(min + (i * step));
	   }
	   results.add(max);

	   return results;
	}

}
