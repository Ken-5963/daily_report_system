package models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 日報データのDTOモデル
 *
 */
@Table(name = JpaConst.TABLE_REP)
@NamedQueries({
	@NamedQuery(
			name = JpaConst.Q_REP_GET_ALL,
			query = JpaConst.Q_REP_GET_ALL_DEF),
    @NamedQuery(
            name = JpaConst.Q_REP_COUNT,
            query = JpaConst.Q_REP_COUNT_DEF),
    @NamedQuery(
            name = JpaConst.Q_REP_GET_ALL_MINE,
            query = JpaConst.Q_REP_GET_ALL_MINE_DEF),
    @NamedQuery(
            name = JpaConst.Q_REP_COUNT_ALL_MINE,
            query = JpaConst.Q_REP_COUNT_ALL_MINE_DEF)
	
})
@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
@Entity
public class Report {
	
    /**
     * id
     */
	@Id
	@Column(name = JpaConst.REP_COL_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	 /**
     * 日報を登録した従業員
     */
    @ManyToOne
    @JoinColumn(name = JpaConst.REP_COL_EMP, nullable = false)
    private Employee employee;

    /**
     * いつの日報かを示す日付
     */
    @Column(name = JpaConst.REP_COL_REP_DATE, nullable = false)
    private LocalDate reportDate;

    /**
     * 日報のタイトル
     */
    @Column(name = JpaConst.REP_COL_TITLE, length = 255, nullable = false)
    private String title;

    /**
     * 日報の内容
     */
    @Lob
    @Column(name = JpaConst.REP_COL_CONTENT, nullable = false)
    private String content;

    /**
     * 登録日時
     */
    @Column(name = JpaConst.REP_COL_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;

    /**
     * 更新日時
     */
    @Column(name = JpaConst.REP_COL_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;


}
