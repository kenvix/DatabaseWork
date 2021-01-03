package com.kenvix.bookmgr.contacts.server

import com.kenvix.bookmgr.contacts.generic.*
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId
import java.time.Instant

data class QuestionPO(
        @BsonId
        var _id: QuestionId = newId(),
        var creatorUid: UserId,
        var content: String,
        var teacherAnswer: String,
        var fullScore: ExamScore,
        var type: Int = QuestionType.Unknown,
        var studentAnswers: MutableMap<UserId, String> = LinkedHashMap(),
        var studentScores: MutableMap<UserId, ExamScore> = LinkedHashMap()
)

data class ExamPO(
        @BsonId
        var _id: ExamId = newId(),
        var creatorUid: UserId,
        var status: Int = ExamStatus.DraftOrHidden,
        var createdAt: Instant = Instant.now(),
        var examName: String = "",
        var examDescription: String = "",
        var examBeginAt: Instant,
        var examEndAt: Instant,
        var fullScore: ExamScore,
        var teachers: MutableMap<UserId, PersonId> = LinkedHashMap(),
        var students: MutableMap<UserId, PersonId> = LinkedHashMap(),
        var questions: MutableList<QuestionId> = ArrayList(),
        /** 学生分数表。Key为学生ID，Value[0]为分数，Value[1]为状态 **/
        var studentTotalScores: LinkedHashMap<UserId, Array<ExamScore>> = LinkedHashMap(),
        var snaps: Id<SnapPO> = newId()
)

data class PersonPO(
        @BsonId
        var _id: PersonId = newId(),
        var uid: UserId,
        var school: String = "",
        var realName: String = "",
        var workerId: String = "",
        var sex: Byte = Sex.Unknown,
        var startYear: Int = 0,
        var description: String = "",
        /** 被邀请参加考试,具有的考试 ID 列表 **/
        var exams: MutableList<ExamId> = ArrayList(),
        /** 创建了某个考试（或参与出题）,具有的考试 ID 列表 **/
        var adminExams: MutableList<ExamId> = ArrayList()
)


data class SnapUnitPO(
        var uid: UserId,
        var fileName: String,
        var fileType: String,
        var description: String = "",
        var flags: Int = 0,
        var time: Instant = Instant.now()
)

data class SnapPO(
        var _id: SnapId = newId(),
        var exam: ExamId,
        val snaps: MutableMap<UserId, MutableList<SnapUnitPO>> = HashMap()
)