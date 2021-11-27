package com.example.electionResult;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ElectionDataTest {

    ElectionData electionData = new ElectionData();

    @BeforeEach
    public void initEach() {
        ByteArrayInputStream in = new ByteArrayInputStream("12\n14\n10".getBytes());
        System.setIn(in);
    }

    @Test
    public void exceptionVotesA() {
        ByteArrayInputStream in = new ByteArrayInputStream("xx\n14\n10\n12".getBytes());
        System.setIn(in);

        PrintStream standardOut = System.out;

        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        electionData.AcceptData();
        assertTrue(new String(captor.toByteArray()).contains("You did not enter valid number."));

        System.setOut(standardOut);
    }

    @org.junit.jupiter.api.Test
    void acceptData() {
        electionData.AcceptData();

        assertEquals(12, electionData.getVotesA());
        assertEquals(14, electionData.getVotesB());
        assertEquals(10, electionData.getStuNotVoted());
    }

    @org.junit.jupiter.api.Test
    void totalVotingPopulation() {
        electionData.AcceptData();
        electionData.TotalVotingPopulation();
        assertEquals(36, electionData.getTotalPopulation());
    }

    @org.junit.jupiter.api.Test
    void calculatePercentage() {
        electionData.AcceptData();
        electionData.TotalVotingPopulation();
        electionData.CalculatePercentage();
        assertEquals(33.33333333333333, electionData.getPercA());
        assertEquals(38.88888888888889, electionData.getPercB());
    }

    @org.junit.jupiter.api.Test
    void winnerCandidate() {
        electionData.AcceptData();
        electionData.TotalVotingPopulation();
        electionData.CalculatePercentage();

        PrintStream standardOut = System.out;

        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        electionData.WinnerCandidate();
        assertEquals("Congratulations! Candidate B is winner.", captor.toString().trim());
        System.setOut(standardOut);
    }
}