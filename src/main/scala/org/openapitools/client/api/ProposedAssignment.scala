package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ProposedAssignment._

case class ProposedAssignment (
  amountPaid: String,
confidence: Double,
customerId: Option[String],
invoiceId: String,
invoiceNumber: String,
openAmount: String,
paymentDate: String,
paymentId: UUID,
reason: String,
reference: Option[String])

object ProposedAssignment {
  import DateTimeCodecs._

  implicit val ProposedAssignmentCodecJson: CodecJson[ProposedAssignment] = CodecJson.derive[ProposedAssignment]
  implicit val ProposedAssignmentDecoder: EntityDecoder[ProposedAssignment] = jsonOf[ProposedAssignment]
  implicit val ProposedAssignmentEncoder: EntityEncoder[ProposedAssignment] = jsonEncoderOf[ProposedAssignment]
}
