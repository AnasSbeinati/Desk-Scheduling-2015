package com.FCI.OS2.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.sound.midi.ControllerEventListener;

public class Simulater {
	ArrayList<Integer> sequence;
	int initial;

	public Simulater(String seq, int initial) {
		sequence = new ArrayList<>();
		try {
			String[] seqs = seq.trim().split(" ");
			for (String string : seqs) {
				int position = Integer.parseInt(string);
				sequence.add(position);
			}
			this.initial = initial;
		} catch (Exception e) {
			System.out.println("here");
		}
	}

	public ArrayList<Integer> FCFS() {
		ArrayList<Integer> out = new ArrayList<>();
		if (sequence.get(0) != initial)
			out.add(initial);
		out.addAll(sequence);
		return out;
	}

	public ArrayList<Integer> SSTF() {
		ArrayList<Integer> temp = new ArrayList<>(sequence);
		ArrayList<Integer> res = new ArrayList<>();
		int position = initial;
		if (!temp.contains(initial))
			res.add(initial);
		while (!temp.isEmpty()) {
			int i = getClosestPosition(temp, position);
			position = temp.remove(i);
			res.add(position);
		}
		return res;
	}

	public ArrayList<Integer> SCAN() {
		ArrayList<Integer> temp = new ArrayList<>(sequence);
		ArrayList<Integer> res = new ArrayList<>();
		if (!temp.contains(initial))
			temp.add(initial);
		Collections.sort(temp);
		int i = temp.indexOf(initial);
		if (i == 0)
			return temp;
		if (i == temp.size() - 1) {
			Collections.reverse(temp);
			if (!temp.contains(4999))
				temp.add(1, 4999);
			return temp;
		}
		res.addAll(temp.subList(i, temp.size()));
		if (!temp.contains(4999))
			res.add(4999);
		ArrayList<Integer> tempSub = new ArrayList<>();
		tempSub.addAll(temp.subList(0, i));
		Collections.reverse(tempSub);
		res.addAll(tempSub);
		return res;
	}

	public ArrayList<Integer> CSCAN() {
		ArrayList<Integer> temp = new ArrayList<>(sequence);
		ArrayList<Integer> res = new ArrayList<>();
		if (!temp.contains(initial))
			temp.add(initial);
		Collections.sort(temp);
		int i = temp.indexOf(initial);
		if (i == 0)
			return temp;
		if (i == temp.size() - 1) {
			if (!temp.contains(0))
				temp.add(0, 0);
			temp.add(0, 4999);
			temp.add(temp.remove(temp.size() - 1));
			return temp;
		}
		res.addAll(temp.subList(i, temp.size()));
		if (!temp.contains(4999))
			res.add(4999);
		if (!temp.contains(0))
			res.add(0);
		res.addAll(temp.subList(0, i));
		return res;
	}

	public ArrayList<Integer> CLOOK() {
		ArrayList<Integer> temp = new ArrayList<>(sequence);
		ArrayList<Integer> res = new ArrayList<>();
		if (!temp.contains(initial))
			temp.add(initial);
		Collections.sort(temp);
		int i = temp.indexOf(initial);
		if (i == 0)
			return temp;
		if (i == temp.size() - 1) {
			temp.add(temp.remove(temp.size() - 1));
			return temp;
		}
		res.addAll(temp.subList(i, temp.size()));
		res.addAll(temp.subList(0, i));
		return res;
	}

	private int getClosestPosition(ArrayList<Integer> temp, int ini) {
		int j = 0, value = Math.abs(temp.get(0) - ini);
		for (int i = 1; i < temp.size(); ++i) {
			int tempValue = Math.abs(temp.get(i) - ini);
			if (tempValue == 0)
				return i;
			if (tempValue < value) {
				value = tempValue;
				j = i;
			}
		}
		return j;
	}

	public Integer getTotalHeadMovement(ArrayList<Integer> mat) {
		int res = 0;
		for (int i = 0; i < mat.size() - 1; i++) {
			res += Math.abs(mat.get(i + 1) - mat.get(i));
		}
		return res;
	}
}
