package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CustomerGroupUpdate._

case class CustomerGroupUpdate (
  description: Option[String],
/* Contact ids that are members of this group. */
  memberIds: Option[List[String]],
/* Rule description for membership, e.g. \"orders > 5 last 12 months\". */
  membershipFilter: Option[String],
/* Unique group name, e.g. \"VIP\", \"Wholesale\", \"Newsletter\". */
  name: Option[String])

object CustomerGroupUpdate {
  import DateTimeCodecs._

  implicit val CustomerGroupUpdateCodecJson: CodecJson[CustomerGroupUpdate] = CodecJson.derive[CustomerGroupUpdate]
  implicit val CustomerGroupUpdateDecoder: EntityDecoder[CustomerGroupUpdate] = jsonOf[CustomerGroupUpdate]
  implicit val CustomerGroupUpdateEncoder: EntityEncoder[CustomerGroupUpdate] = jsonEncoderOf[CustomerGroupUpdate]
}
