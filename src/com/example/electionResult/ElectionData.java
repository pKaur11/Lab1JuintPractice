package com.example.electionResult;

import java.util.Scanner;

public class ElectionData {
    private int votesA;
    private int votesB;
    private int stuNotVoted;
    private int totalPopulation;
    private double percA;
    private double percB;

    public int getVotesA() {
        return votesA;
    }

    public void setVotesA(int votesA) {
        this.votesA = votesA;
    }

    public int getVotesB() {
        return votesB;
    }

    public void setVotesB(int votesB) {
        this.votesB = votesB;
    }

    public int getStuNotVoted() {
        return stuNotVoted;
    }

    public void setStuNotVoted(int stuNotVoted) {
        this.stuNotVoted = stuNotVoted;
    }

    public int getTotalPopulation() {
        return totalPopulation;
    }

    public void setTotalPopulation(int totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public double getPercA() {
        return percA;
    }

    public void setPercA(double percA) {
        this.percA = percA;
    }

    public double getPercB() {
        return percB;
    }

    public void setPercB(double percB) {
        this.percB = percB;
    }

    public void AcceptData() {
        boolean validVotesA = false;
        boolean validVotesB = false;
        boolean validAbstainStu = false;

        Scanner key = new Scanner(System.in);

        while (!validVotesA) {
            System.out.println("Enter votes for candidate A: ");
            String input = key.next();
            try {
                this.votesA = Integer.parseInt(input);
                validVotesA = true;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter valid number.");
            }
        }

        while (!validVotesB) {
            System.out.println("Enter votes for candidate B: ");
            String input1 = key.next();
            try {
                this.votesB = Integer.parseInt(input1);
                validVotesB = true;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter valid number.");
            }
        }

        while (!validAbstainStu) {
            System.out.println("Enter number of students who did not vote or who abstain: ");
            String input2 = key.next();
            try {
                this.stuNotVoted = Integer.parseInt(input2);
                validAbstainStu = true;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter valid number.");
            }
        }

    }

    public void TotalVotingPopulation() {
        this.totalPopulation = this.votesA + this.votesB + this.stuNotVoted;
    }

    public void CalculatePercentage() {
        this.percA = (((double)(this.votesA)/(double)(this.totalPopulation)) * 100);

        this.percB = (((double)(this.votesB)/(double)(this.totalPopulation)) * 100);
    }

    public void WinnerCandidate() {
        if(this.percA > this.percB) {
            System.out.println("Congratulations! Candidate A is winner.");
        } else if(this.percA < this.percB) {
            System.out.println("Congratulations! Candidate B is winner.");
        } else {
            System.out.println("Tie");
        }
    }

    public static void main(String[] args) {
        ElectionData electionData = new ElectionData();
        electionData.AcceptData();
        electionData.TotalVotingPopulation();
        electionData.CalculatePercentage();
        electionData.WinnerCandidate();
    }
}
