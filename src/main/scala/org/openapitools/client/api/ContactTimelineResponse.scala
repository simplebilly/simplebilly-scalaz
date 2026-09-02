package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ContactTimelineResponse._

case class ContactTimelineResponse (
  contactId: String,
events: List[TimelineEvent])

object ContactTimelineResponse {
  import DateTimeCodecs._

  implicit val ContactTimelineResponseCodecJson: CodecJson[ContactTimelineResponse] = CodecJson.derive[ContactTimelineResponse]
  implicit val ContactTimelineResponseDecoder: EntityDecoder[ContactTimelineResponse] = jsonOf[ContactTimelineResponse]
  implicit val ContactTimelineResponseEncoder: EntityEncoder[ContactTimelineResponse] = jsonEncoderOf[ContactTimelineResponse]
}
