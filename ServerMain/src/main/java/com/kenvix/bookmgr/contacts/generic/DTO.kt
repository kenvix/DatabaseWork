@file:Suppress("unused")

package com.kenvix.bookmgr.contacts.generic

data class UserDTO (
        val uid: UserId,
        val name: String,
        val email: String = "",
        val phone: Long = 0,
        val role: Short = Role.Unknown,
        val createTime: Long = 0,
        val loginTime: Long = 0,
        val createIp: String = "",
        val loginIp: String = "",
        val personId: ClientPersonId,
        val person: PersonDTO? = null,
        var token: String? = null
)

data class QuestionDTO(
        val _id: ClientQuestionId,
        val creatorUid: UserId,
        /** 题目内容 **/
        val content: String,
        /** 教师参考答案。对于学生端且教师未公布答案的考试，这个字段总为空字符串 **/
        val teacherAnswer: String,
        /** 为了减少麻烦，分数就用Int。但并不是不支持小数。1分x100 **/
        val fullScore: ExamScore,
        val type: Int = QuestionType.Unknown,
        /** 学生答案。对于学生端，这个 Map 只包含 0 或 1（自己的答案）个元素 **/
        val studentAnswers: Map<UserId, String> = emptyMap(),
        /** 学生得分。对于学生端，这个 Map 只包含 0 或 1（自己的得分）个元素 **/
        val studentScores: Map<UserId, ExamScore> = emptyMap()
)

data class PersonDTO(
        val _id: ClientPersonId,
        val uid: UserId,
        val school: String = "",
        val realName: String = "",
        val workerId: String = "",
        val sex: Byte = Sex.Unknown,
        val startYear: Int = 0,
        val description: String = "",
        /** 被邀请参加考试,具有的考试 ID 列表 **/
        val exams: List<ClientExamId> = emptyList(),
        /** 创建了某个考试（或参与出题）,具有的考试 ID 列表 **/
        val adminExams: List<ClientExamId> = emptyList()
)

data class IDResultDTO(val id: UserId)

data class ExamStudentDTO(
        val _id: ClientExamId,
        val status: Int = 0,
        val examName: String = "",
        val examDescription: String = "",
        val examBeginAt: Long = 0,
        val examEndAt: Long = 0,
        val fullScore: ExamScore,
        /** 学生端问题 **/
        val questions: Map<ClientQuestionId, QuestionDTO> = emptyMap(),
        val studentTotalScore: ExamScore = 0
)

data class ExamTeacherDTO(
        val _id: ClientExamId,
        val creatorUid: UserId,
        val createdAt: Long,
        val status: Int = 0,
        val examName: String,
        val examDescription: String,
        val examBeginAt: Long,
        val examEndAt: Long,
        val fullScore: ExamScore,
        val teachers: Map<UserId, PersonDTO> = emptyMap(),
        val students: Map<UserId, PersonDTO> = emptyMap(),
        /** 题目信息。在查询概要信息时为空 Map **/
        val questions: Map<ClientQuestionId, QuestionDTO> = emptyMap(),
        /** 学生分数表。Key为学生ID，Value[0]为分数，Value[1]为状态 **/
        val studentTotalScores: Map<UserId, Array<ExamScore>> = emptyMap()
)
