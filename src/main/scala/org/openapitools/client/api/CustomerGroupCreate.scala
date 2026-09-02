package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CustomerGroupCreate._

case class CustomerGroupCreate (
  description: Option[String],
/* Contact ids that are members of this group. */
  memberIds: Option[List[String]],
/* Rule description for membership, e.g. \"orders > 5 last 12 months\". */
  membershipFilter: Option[String],
/* Unique group name, e.g. \"VIP\", \"Wholesale\", \"Newsletter\". */
  name: String)

object CustomerGroupCreate {
  import DateTimeCodecs._

  implicit val CustomerGroupCreateCodecJson: CodecJson[CustomerGroupCreate] = CodecJson.derive[CustomerGroupCreate]
  implicit val CustomerGroupCreateDecoder: EntityDecoder[CustomerGroupCreate] = jsonOf[CustomerGroupCreate]
  implicit val CustomerGroupCreateEncoder: EntityEncoder[CustomerGroupCreate] = jsonEncoderOf[CustomerGroupCreate]
}
