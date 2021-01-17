package com.sol.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	@Column(name="HEADER")
	private String header;
	@Column(name="ANS_ONE")
	private String ans_one;
	@Column(name="ANS_TWO")
	private String ans_two;
	@Column(name="ANS_THREE")
	private String ans_three;
	@Column(name="ANS_FOUR")
	private String ans_four;
	@Column(name="CORRECT_ANS")
	private int correct_ans;
	@Column(name="EXPLANATION")
	private String explanation;
	@Column(name="TIMESTAMP")
	private float timestamp;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lesson_id")
	private Lesson lesson;
	
	public Question() {}
	
	public Question(long id, String header, String ans_one, String ans_two, String ans_three, String ans_four,
			int correct_ans, String explanation, float timestamp, Lesson lesson) {
		super();
		this.id = id;
		this.header = header;
		this.ans_one = ans_one;
		this.ans_two = ans_two;
		this.ans_three = ans_three;
		this.ans_four = ans_four;
		this.correct_ans = correct_ans;
		this.explanation = explanation;
		this.timestamp = timestamp;
		this.lesson = lesson;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(String header) {
		this.header = header;
	}
	/**
	 * @return the ans_one
	 */
	public String getAns_one() {
		return ans_one;
	}
	/**
	 * @param ans_one the ans_one to set
	 */
	public void setAns_one(String ans_one) {
		this.ans_one = ans_one;
	}
	/**
	 * @return the ans_two
	 */
	public String getAns_two() {
		return ans_two;
	}
	/**
	 * @param ans_two the ans_two to set
	 */
	public void setAns_two(String ans_two) {
		this.ans_two = ans_two;
	}
	/**
	 * @return the ans_three
	 */
	public String getAns_three() {
		return ans_three;
	}
	/**
	 * @param ans_three the ans_three to set
	 */
	public void setAns_three(String ans_three) {
		this.ans_three = ans_three;
	}
	/**
	 * @return the ans_four
	 */
	public String getAns_four() {
		return ans_four;
	}
	/**
	 * @param ans_four the ans_four to set
	 */
	public void setAns_four(String ans_four) {
		this.ans_four = ans_four;
	}
	/**
	 * @return the correct_ans
	 */
	public int getCorrect_ans() {
		return correct_ans;
	}

	/**
	 * @param correct_ans the correct_ans to set
	 */
	public void setCorrect_ans(int correct_ans) {
		this.correct_ans = correct_ans;
	}
	/**
	 * @return the timestamp
	 */
	public float getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(float timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * @return the explanation
	 */
	public String getExplanation() {
		return explanation;
	}

	/**
	 * @param explanation the explanation to set
	 */
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	/**
	 * @return the lesson
	 */
	public Lesson getLesson() {
		return lesson;
	}
	/**
	 * @param lesson the lesson to set
	 */
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", header=" + header + ", ans_one=" + ans_one + ", ans_two=" + ans_two
				+ ", ans_three=" + ans_three + ", ans_four=" + ans_four + ", correct_ans=" + correct_ans
				+ ", explanation=" + explanation + ", timestamp=" + timestamp + ", lesson=" + lesson + "]";
	}
	
}
