package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import OpenItem._

case class OpenItem (
  amountDue: String,
amountPaid: String,
customerId: Option[String],
daysOverdue: Option[Long],
dueDate: Option[String],
invoiceId: String,
invoiceNumber: String,
issueDate: String,
openAmount: String,
reminderLevel: ReminderLevel)

object OpenItem {
  import DateTimeCodecs._

  implicit val OpenItemCodecJson: CodecJson[OpenItem] = CodecJson.derive[OpenItem]
  implicit val OpenItemDecoder: EntityDecoder[OpenItem] = jsonOf[OpenItem]
  implicit val OpenItemEncoder: EntityEncoder[OpenItem] = jsonEncoderOf[OpenItem]
}
